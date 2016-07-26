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

  def 'logIn creates a relevant currentUser and stores the user in the users array'(){
    when:
    controller.createNewUser("Spike")

    then:
    controller.currentUser.name == "Spike"
    controller.users.size() == 1
  }

}
