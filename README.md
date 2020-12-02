# Install Docker Images:

**Run Images:**
* docker run --name mongo --restart=always -d -p 27017:27017 mongo
* docker run --name redis --restart=always -d -p 6379:6379 redis
* docker run -i -t --name tweet-app -p 0.0.0.0:8000:8000 --link mongo:mongo tweet-app

# Install Chrome Driver:

* Download chrome driver
* sudo mv chromedriver /usr/bin/chromedriver
* unzip -p chromedriver_linux64.zip 
* sudo unzip -o /tmp/chromedriver_linux64.zip -d /usr/bin
* sudo unzip -o chromedriver_linux64.zip -d /usr/bin
* chromedriver -v

**For permission:**
   * sudo chown root:root /usr/bin/chromedriver
   * sudo chmod +x /usr/bin/chromedriver

