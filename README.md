# CoinMarketTest

This project contains Coin Market UI Tests
In order the run eacb test, follow the following procedure:

1)Under src/test/resources folder, there are 3 feature files in "Features" folder. Each file is a feature file for test1, 2 and 3. Open "Features" folder.
2)Under src/main/resources folder, the chromedriver is placed. If your chrome browser has a different version than 86, then please update the chromedriver.
3)Update the location of the chromedriver in java files under src/test/java/StepDefinations.
4)Open each feature file and run one by one by right clicking and choosing RUn As->Cucumber Feature. 


Note: Test 3 is incomplete as the description provided in the test is not according to the UI of the "https://coinmarketcap.com/". I am unable to find "full list" options under the  Cryptocurrencies tab. "Also three dropdown menus" are also not visible. 
