import spock.lang.Specification

class MomentSpec extends Specification {

  def moment

  def setup() {
    moment = new Moment("hello", "Tue 26/07/2016 12:13")
  }

  def 'initialize with a body'() {
    when:
    def res = moment.body

    then:
    res == "hello"
  }

  def 'initialize with a timestamp'() {
    when:
    def res = moment.timestamp

    then:
    res == "Tue 26/07/2016 12:13"
  }
}
