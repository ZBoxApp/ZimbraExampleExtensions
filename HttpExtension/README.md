## Intro
Example that shows how to add a new endpoint to process HTTP requests.

This extension will be available on `http://localhost:7080/service/HttpExtension/http`

```
$ curl http://localhost:7080/service/extension/HttpExtension/http
It Works!!!!

```

## Components

* [./src/com/zboxapp/HttpExtension.java](./src/com/zboxapp/HttpExtension.java), register our extension,
* [./src/com/zboxapp/HttpExtensionHandler.java](./src/com/zboxapp/HttpExtensionHandler.java), its where the processing of the http request take places.

## Run the Example
Inside the vagrant vm (`vagrant ssh`):

```
$ cd /vagrant/HttpExtension
$ ant jar
$ sudo mkdir /opt/zimbra/lib/ext/HttpExtension
$ sudo cp /vagrant/HttpExtension/dist/HttpExtension.jar /opt/zimbra/lib/ext/HttpExtension
$ sudo su - zimbra -c "zmmailboxdctl restart"
```

You can check the status of the Extension by looking the `mailbox.log`:

```
$ sudo grep HttpExtension /opt/zimbra/log/mailbox.log
2017-03-31 15:30:24,356 INFO  [main] [] extensions - extension com.zboxapp.HttpExtension found in /opt/zimbra/lib/ext/HttpExtension/HttpExtension.jar
2017-03-31 15:30:24,405 INFO  [main] [] extensions - registered handler at /HttpExtension/http
2017-03-31 15:30:24,405 INFO  [main] [] extensions - Initialized extension HttpExtension: com.zboxapp.HttpExtension@com.zimbra.cs.extension.ZimbraExtensionClassLoader@2c282004
```

Check if it works

```
$ curl http://localhost:7080/service/extension/HttpExtension/http
It Works!!!!
```

