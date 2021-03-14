from urllib import request
# from bs4 import BeautifulSoup
from fake_useragent import UserAgent
import re

url='https://blog.csdn.net/weixin_45070922'
genua = UserAgent()
header = {
    'User-Agent':genua.random,
}
# print(genua.random)
req = request.Request(url,headers = header)
req = request.urlopen(req)
con = req.read().decode('utf-8')
# print(con)
result = con.split("关注/订阅")[1]

result = result.split("\n")[0]
# print(result)

result = result.split("<div data-v-0db42936>")[1:]
# print(result)

for item in result:
    url=item.split("=")[2].strip()[1:-1]
    url=url.split(" ")[0].strip()[:-1]
    print(url)
    req = request.Request(url,headers = header)
    req = request.urlopen(req)
    con = req.read().decode('utf-8')
    print(req.status)


# rs = re.findall(r'<script>(.*?)</script>',result,re.S)
# print(rs[1])