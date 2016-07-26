import spock.lang.Specification

class ControllerSpec extends Specification {

  def controller

  def setup() {
    controller = new Controller()

  }

  def 'initialize with an empty users array'() {
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

  def 'logIn creates a relevant currentUser'(){
    when:
    controller.logIn("Spike")
    def res = controller.currentUser

    then:
    res.name == "Spike"
  }

  def 'logOut changes the currentUser back to null'() {
    when:
    controller.logIn("Spike")
    controller.logOut()
    def res = controller.currentUser

    then:
    res == null 

  }

}
