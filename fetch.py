from urllib import request
from fake_useragent import UserAgent
from bs4 import BeautifulSoup
import re
ge = UserAgent()
url = 'http://www.66ip.cn/mo.php?sxb=&tqsl=10&port=&export=&ktip=&sxa=&submit=%CC%E1++%C8%A1&textarea='
head = {'User-Agent':ge.random}

req = request.Request(url,headers=head)
req = request.urlopen(req)
con = req.read().decode('gb2312')
# print(con)
obj = BeautifulSoup(con, 'html5lib')
listip = [item for item in obj.stripped_strings if re.match(r'\d', item)]
validips = []
for ip in listip:
    print(ip)
    ip = {'http': ip}
    proxy = request.ProxyHandler(ip)
    opener = request.build_opener(proxy)
    url = 'http://www.baidu.com'
    headinfo = {'User-Agent': ge.random}
    reqhd = request.Request(url, headers=headinfo)
    try:
        req = opener.open(reqhd)
    except Exception as e:
        print ('invalid ip:', ip, e)
        # continue
    if req.status == 200:
        validips.append(ip)
print(len(validips))
for ip in validips:
    print(ip)