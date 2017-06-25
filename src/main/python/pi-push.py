import RPi.GPIO as GPIO
import time
from subprocess import call

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.IN, pull_up_down=GPIO.PUD_UP)

while True:
  inputValue = GPIO.input(18)
  if (inputValue == False):
    call(["java", "-Xmx768m", "-Xms768m", "-jar", "/home/lamon/jar/web3j-test-1.0.2.jar", "web3jio0107", "/home/lamon/.ethereum/testnet/keystore/UTC--2017-06-12T14-53-36.157000000Z--b9927a78e40cedfa2b2d1bdda2ba79b9cc75e6c6.json"])
  time.sleep(0.3)
