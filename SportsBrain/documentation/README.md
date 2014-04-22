e4-tutorial
===========

These are the reference projects for my Eclipse 4 Application Platform tutorial.

Tycho Build
-----------
* Have Maven 3 installed
* Clone this Git repo
* Open a shell in project eclipse.sportsBrain.e4.cards.build.tycho
* Run command "mvn clean install"
* Wait a while (first build takes long) until the build succeeds
* The results for Win (32/64) and Linux GTK (32/64) and Mac Cocoa (32/64) are in project eclipse.sportsBrain.e4.cards.product/target/products

e4 Application Model Extension
------------------------------
* In the project eclipse.sportsBrain.e4.cards.model.application you find a small extension to the Eclipse 4 application model
* This extension is used in the Application-with-extension.xmi file of project eclipse.sportsBrain.e4.cards
* To open the Application-with-extension.xmi in your running Eclipse IDE (in model editors), you have to export the project eclipse.sportsBrain.e4.cards.model.application in to your running IDE.
* To export, open MANIFEST.MF, in the Overview-Tab click on "Export Wizard" and then choose "Install into host. Repository:"
* Restart your Eclipse SDK, now you should be able to open Application.e4xmi
* If you don't want to install the model extension into your running Eclipse SDK, you could just start a new Eclipse SDK instance and make sure that the project eclipse.sportsBrain.e4.cards.model.application is checked in the Run-Configuration.

License
-------
All Source Code Files are licensed under the Eclipse Public License - v 1.0
http://www.eclipse.org/legal/epl-v10.html
