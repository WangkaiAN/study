from urllib import request
url = 'http://httpbin.org/get'
req = request.urlopen(url)
obj = req.read().decode('utf-8')
# print(obj)

# url = 'https://movie.douban.com/top250'
hds = {
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "Accept-Encoding": "gzip, deflate",
    "Accept-Language": "zh-CN,zh;q=0.9",
    "Host": "httpbin.org",
    "Upgrade-Insecure-Requests": "1",
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36",
    "X-Amzn-Trace-Id": "Root=1-604427e5-78b45a25264d73346fe7be22"
}
reqhd = request.Request(url,headers = hds)
req =request.urlopen(reqhd)
print(req.read().decode('utf-8'))

