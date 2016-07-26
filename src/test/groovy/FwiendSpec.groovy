import spock.lang.Specification

class FwiendSpec extends Specification {

  def spike
  def nikesh
  def leo
  def momentClass

  def setup() {
    momentClass = Mock(Moment.class)
    spike = new Fwiend("Spike")
    nikesh = new Fwiend("Nikesh")
    leo = new Fwiend("Leo")
    nikesh.addMoment("This is my Moment")
  }

  def 'initialize with a name'() {
    when:
    def res = spike.name

    then:
    res == "Spike"
  }

  def 'initialize with a moments array'() {
    when:
    def res = spike.moments

    then:
    res.size() == 0
  }

  def 'adds a post to the moments array'() {
    when:
    spike.addMoment("post")
    def res = spike.moments

    then:

    res[0].body == "post"
  }

  def "Users start without following anyone"() {
    when:
    def res = spike.fwiends

    then:
    res.size() == 0
  }

  def "Spike can see Nikesh' moments"(){
    when:
    def res = spike.viewMomentsOf(nikesh)

    then:
    res[0].body == "This is my Moment"
  }

  def "Spike can add Nikesh to Fwiends List"() {
    when:
    spike.addToFwiends(nikesh)
    spike.addToFwiends(leo)
    def res = spike.fwiends

    then:
    res.size() == 2
    res[0].name == "Nikesh"
    res[1].name == "Leo"
  }

  // def 'Moment receives the new method'(){
  //   when:
  //   spike.add("post")
  //
  //   then:
  //   1 * momentClass.newInstance("post")
  // }

}
