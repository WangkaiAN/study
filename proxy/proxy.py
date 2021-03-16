#coding:utf-8
import fake_useragent
from urllib import request
ip = {'http':'114.249.115.71:9000'}
proxy = request.ProxyHandler(ip)
opener = request.build_opener(proxy)

ua = fake_useragent.FakeUserAgent()
url = 'http://httpbin.org/ip'
headinfo = {'User-Agent':ua.random}
reqhd = request.Request(url, headers=headinfo)
req = opener.open(reqhd)
print (req.read().decode('utf-8'))