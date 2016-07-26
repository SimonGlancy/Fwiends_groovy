import spock.lang.Specification

class MomentSpec extends Specification {

  def moment

  def setup() {
    moment = new Moment("hello")
  }

  def 'initialize with a body'() {
    when:
    def res = moment.body

    then:
    res == "hello"
  }
}
