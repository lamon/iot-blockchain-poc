import RPi.GPIO as GPIO
import time
from subprocess import call

GPIO.setmode(GPIO.BCM)
GPIO.setup(18, GPIO.IN, pull_up_down=GPIO.PUD_UP)

while True:
  inputValue = GPIO.input(18)
  if (inputValue == False):
    call(["java", "-Xmx768m", "-Xms768m", "-jar", "web3j-test-1.0.2.jar", "walletPassword", "/home/wallet/path/wallet.json"])
  time.sleep(0.3)
