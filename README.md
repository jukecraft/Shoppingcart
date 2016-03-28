# Shoppingcart
Shoppingcart
**** Usage and Integration details ***

*Step 1*
The component is usable from API com.hmrc.shop.bom.BillCalculator.generate(String[] items). The method returns the cost as a double. 

*Step 2*
Prior to initialising the BillCalculator, the integrator is requested to choose a Calculator and initialize the instance with the following two key-values.
The keys are FRUIT_PROPERTYFILE and OFFER_PROPERTYFILE. The values are the file names of the initialization file with values.
The files are property files and should follow the conventions of property files.

For example, fruit.properties could have the name of the fruit and its unit cost.
Mango=2.1
Jackfruit=3.2

The example for offer.properties could be as follows
Mango=com.hmrc.shop.offer.OfferBuy1Get1
Kiwi=com.hmrc.shop.offer.Offer3For2 

The current offers supported by the program are com.hmrc.shop.offer.OfferBuy1Get1 and com.hmrc.shop.offer.Offer3For2.
New offers can be added with third party libraries(they have to extend Offer.class). The new libraries does not require recompilation of the candidate's work.
 
 
*** BDD Usage note *** 
BDD is used as a high quality communication only. Hence, the elaborate testing is done at the TDD.
Study link of the candidate - http://tooky.co.uk/the-cucumber-test-trap/
The TDD has more tests than the Cucumber, as suggested by Aslak and team.

*** Design decisions ***
Why have you removed some of the files that you checkedin from the initial commit ?
Initially, I had planned to come up with a command line interface that the user can enter the name of the fruits. However, the spec did not mention that the user has to enter values. Also, the input was single that can be passed as arguments. Hence, the interactive files are removed. Also, some other files are renamed to better commnicate its responsiblity.

Why are comments missing in some files?
I realised the comments should be very useful in generating the java doc. However, the methods are granular and the naming of the methods speaks volumes than 
detail documentation. The comments would have added to the perfection.

Why have used the Offer class names as the key?
The Offer class names as indicator serves two purposes. Firstly, it serves as unique identifier, Secondly, it helps in adding new Offer functionalities configurable without the requirement to recompile the Shopping cart framework. Its powerful because we are open to accept any number of new offers.

Why are files such as .spring present in the check-in ?
The code does not use spring. The code is a maven project developed using spring tool suite. .spring files are part of the eclipse ide. If the developer prefers to import the archive in spring tool suite, the complete set of files would help in a happy import.

Why have you written beware of null at some occasions? 
I have extensively used streams and lambda. The handling of null and exceptions is not pleasant. Hence, I filter the null and exceptions using predicate before accesing those methods. Therby, avoiding the impact of null or exceptions. However, the methods are potential candidates that return null or exception. The developer is warned and is suggested to use the predicate in the java doc comments.

*** Opportunities for improvement ***
The following code sinppet was noticed after the check-in. This could have been better handled.

DecimalFormat df = new DecimalFormat("#.##"); in Calculator.java line 144. This could have been specified as a global variable.

The Step 2 of handling offers is developed as part of the Calculator method. If one would consider Step 2 as a new requirement or a change request, it is nice to extend the Calculator as CalculateWithOffer, override the generate method, and reuse the super class method's functionality. Thereby 'Open to extension and Close to Modification' principle would be respected.

The Fruit inventory could have had a double dimensional array to store the fruit store. It would have made the retrieval (getItem implementation) relatively faster.
