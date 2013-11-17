import urllib2
import re

f = open("/home/maxime/git/hskme/dico/hsk2") ;
for line in f:
    word = line.split(",")
    pinyin = re.compile("\D*[\d$]")
    for w in pinyin.findall(word[1]):
        print w
        url = "http://www.chine-nouvelle.com/jdd/public/ct/pinyinaudio/" + w + ".mp3"
        print url
        file_name = url.split('/')[-1]
        try:
            u = urllib2.urlopen(url)
            f = open(file_name, 'wb')
            meta = u.info()
            file_size = int(meta.getheaders("Content-Length")[0])
            print "Downloading: %s Bytes: %s" % (file_name, file_size)
            file_size_dl = 0
            block_sz = 8192
            while True:
                buffer = u.read(block_sz)
                if not buffer:
                    break
               
                file_size_dl += len(buffer)
                f.write(buffer)
                status = r"%10d  [%3.2f%%]" % (file_size_dl, file_size_dl * 100. / file_size)
                status = status + chr(8)*(len(status)+1)
                print status,
               
            f.close()
        except:
            print "exception 404 not found " + w
             