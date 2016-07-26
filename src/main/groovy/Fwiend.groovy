class Fwiend {

  String name
  def moments
  private def momentKlass
  def fwiends

  def Fwiend( name, Class momentClass = Moment ) {
    this.name = name
    this.momentKlass = momentClass
    this.moments = []
    this.fwiends = []
  }

  def addMoment(body, timestamp) {
    def moment = momentKlass.newInstance(body, timestamp)
    this.moments << moment
  }

  def viewMomentsOf(fwiend) {
    fwiend.moments
  }

  def addToFwiends(fwiend) {
    this.fwiends << fwiend
  }
}
