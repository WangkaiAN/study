# -*- coding:utf-8 -*-
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
import time


class QiangTickets(object):

    def __init__(self):
        self.option = webdriver.ChromeOptions()
        self.option.add_argument("--no-sandbox")
        # 将chrome浏览器隐藏
        # self.option.add_argument("--headless")
        self.login_url = "https://kyfw.12306.cn/otn/resources/login.html"
        # https://kyfw.12306.cn/otn/leftTicket/init
        self.initmy_url = "https://kyfw.12306.cn/otn/view/index.html"
        self.search_url = "https://kyfw.12306.cn/otn/leftTicket/init"
        self.passenger_url = "https://kyfw.12306.cn/otn/confirmPassenger/initDc"
        # 注意下面Chrome的大小写字母开头必须是大写
        self.driver = webdriver.Chrome(executable_path='/virenv/py3/lib/python3.6/site-packages/chromedriver',
                                       chrome_options=self.option)

    def wait_input(self):
        # 手动输入（较灵活）
        self.from_station = input("出发地：")
        self.to_station = input("目的地：")
        self.depart_time = input("出发时间：")
        self.passengers = input("请输入乘客姓名（如有多个请用英文逗号隔开）：").split(",")
        self.trains = input("车次（如有多个车次用英文逗号隔开）：").split(",")

    def _login(self):
        self.driver.get(self.login_url)
        self.driver.find_element_by_xpath(".//ul/li[2][@class='login-hd-account']").click()
        time.sleep(1)
        # 输入用户名    《注》将代码给别人前要将send_keys中的内容清空
        self.driver.find_element_by_id("J-userName").send_keys("输入用户名")
        time.sleep(1)
        # 输入密码
        self.driver.find_element_by_id("J-password").send_keys("输入密码")
        # 显式等待
        WebDriverWait(self.driver, 1000).until(
            EC.url_to_be(self.initmy_url)
        )
        print("登陆成功！")

    def _order_ticket(self):
        # 请求订票页面
        self.driver.get(self.search_url)
        # 等待用户输入出发地并进行比较
        WebDriverWait(self.driver, 1000).until(
            EC.text_to_be_present_in_element_value((By.ID, "fromStationText"), self.from_station)
        )
        # 等待用户输入目的地并进行比较
        WebDriverWait(self.driver, 1000).until(
            EC.text_to_be_present_in_element_value((By.ID, "toStationText"), self.to_station)
        )
        # 等待用户输入出发时间并进行比较
        WebDriverWait(self.driver, 1000).until(
            EC.text_to_be_present_in_element_value((By.ID, "train_date"), self.depart_time)
        )
        # 不停的循环查询，直到抢到票为止！
        MASK_LOOP = True
        while MASK_LOOP:
            time.sleep(0.8)
            # 等待查询按钮是否可点击
            WebDriverWait(self.driver, 1000).until(
	            EC.element_to_be_clickable((By.ID, "query_ticket"))
	        )
            # 如果可以点击则触发查询事件
            searchBtn = self.driver.find_element_by_id("query_ticket")
            searchBtn.click()
            # 等待车次信息显示出来
            WebDriverWait(self.driver, 1000).until(
	            EC.presence_of_element_located((By.XPATH, ".//tbody[@id='queryLeftTable']/tr"))
	        )
            print("正在努力抢票中，请稍等...")
             # 获取需要的tr标签
            tr_list = self.driver.find_elements_by_xpath(".//tbody[@id='queryLeftTable']/tr[not(@datatran)]")
            # 遍历满足条件的车次信息
            for tr in tr_list:
                train_number = tr.find_element_by_class_name("number").text
                if train_number in self.trains:
                    left_ticket = tr.find_element_by_xpath(".//td[4]").text
                    if left_ticket == "有" or left_ticket.isdigit:
                        MASK_LOOP = False
                        print("太好了，终于抢到了！")
                        orderBtn = tr.find_element_by_class_name("btn72")
                        orderBtn.click()
                        # 等待是否来到了乘客页面
                        WebDriverWait(self.driver, 1000).until(
	                        EC.url_to_be(self.passenger_url)
	                    )
                        # 选择用户
                        presence_list = self.driver.find_elements_by_xpath(".//ul[@id='normal_passenger_id']/li")
                        # print(presence_list)
                        for presence_label in presence_list:
                            time.sleep(0.6)
                            presence_name = presence_label.find_element_by_xpath("./label").text
                             # print(presence_name)
                            if presence_name in self.passengers:
                                # print(presence_name)
	                            presence_label.find_element_by_class_name("check").click()
                        time.sleep(0.8)
                        submit_btn = self.driver.find_element_by_id("submitOrder_id")
                        submit_btn.click()
                        time.sleep(0.8)
                        self.driver.find_element_by_id("qr_submit_id").click()
                        break

    def run(self):
        self.wait_input()
        self._login()
        self._order_ticket()


if __name__ == '__main__':
    spider = QiangTickets()
    spider.run()
