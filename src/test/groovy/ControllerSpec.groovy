import spock.lang.Specification

class ControllerSpec extends Specification {

  def controller

  def setup(){
    controller = new Controller()
  }

  def 'initialize with an empty users array'(){
    when:
    def res = controller.users

    then:
    res.size() == 0
  }

  def 'initializes with a currentUser = null'(){
    when:
    def res = controller.currentUser

    then:
    res == null
  }

  def 'logIn creates a relevant currentUser and stores the user in the users array'(){
    when:
    controller.logIn("Spike")

    then:
    controller.currentUser.name == "Spike"
    controller.users.size() == 1
  }

  def 'logOut changes the currentUser back to null'(){
    when:
    controller.logIn("Spike")
    controller.logOut()
    def res = controller.currentUser

    then:
    res == null
  }

  def 'if user has already created an account no new instance is added to the users array'(){
    when:
    controller.logIn("Spike")
    controller.logOut()
    controller.logIn("Spike")

    then:
    controller.users.size() == 1
  }

 def 'it allows multiple users to login'(){
   when:
   controller.logIn("Spike")
   controller.logOut()
   controller.logIn("Nikesh")

   then:
   controller.currentUser.name == "Nikesh"
   controller.users.size() == 2
 }

 def 'it allows the currentUser to create a moment'(){
   when:
   controller.logIn("Spike")
   controller.logOut()
   controller.logIn("Nikesh")
   controller.createMoment("This is My Moment", "Tue 26/07/2016 12:13")

   then:
   controller.currentUser.moments.size() == 1
 }

 def 'it allows the currentUser to view a timeline of their choice'(){
   when:
   controller.logIn("Spike")
   controller.logOut()
   controller.logIn("Nikesh")
   controller.createMoment("This is My Moment", "Tue 26/07/2016 12:13")
   controller.createMoment("This is My Perfect Moment", "Tue 27/07/2016 15:13")
   controller.logOut()
   controller.logIn("Spike")
   def res = controller.viewTimeLineOf("Nikesh")

   then:
   res == "Nikesh Posted on Tue 26/07/2016 12:13 | This is My Moment\nNikesh Posted on Tue 27/07/2016 15:13 | This is My Perfect Moment\n"
 }

 def 'it throws an error if searching for an invalid user'(){
   when:
   controller.logIn("Spike")
   def res = controller.viewTimeLineOf("Barry")

   then:
   res == "Can't find Barry Please enter valid user"
 }

 def 'it allows a user to follow another user'(){
   when:
   controller.logIn("Spike")
   controller.logOut()
   controller.logIn("Nikesh")
   controller.follow("Spike")

   then:
   controller.currentUser.fwiends.size() == 1
 }

 def 'it throws an error if searching for an invalid user'(){
   when:
   controller.logIn("Spike")
   controller.logOut()
   controller.logIn("Nikesh")
   def res = controller.follow("Barry")

   then:
   res == "Can't find Barry Please enter valid user"
 }

 def 'it allows a user to show their fwiends'(){
   when:
   controller.logIn("Spike")
   controller.logOut()
   controller.logIn("Nikesh")
   controller.follow("Spike")

   then:
   controller.showFwiends() == "You're Fwiends with:\nSpike\n"
 }

 def 'it throws an error if a user has no fwiends'(){
   when:
   controller.logIn("Spike")
   controller.logOut()
   controller.logIn("Nikesh")

   then:
   controller.showFwiends() == "Sorry you haven't got any Fwiends yet..."
 }

}
