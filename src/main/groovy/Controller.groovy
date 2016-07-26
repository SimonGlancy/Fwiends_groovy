class Controller {
  def users
  def currentUser
  private def fwiendKlass

  def Controller(Class fwiendClass = Fwiend) {
    this.users = []
    this.currentUser = null
    this.fwiendKlass = fwiendClass
  }

  def logIn(name) {
    !findUser(name) ? createNewUser(name) : assignToCurrentUser(name)
  }

  def logOut() {
    this.currentUser = null
  }

  def follow(name) {
    !findUser(name) ? formatErrorString(name) : addToFwiends(name)
  }

  def createMoment(body, dateStamp){
    currentUser.addMoment(body, dateStamp)
  }

  def viewTimeLineOf(name){
    !findUser(name) ? formatErrorString(name) : formatTimeline(name)
  }

  private def formatTimeline(name){
    def foundUser = findUser(name)
    String presentationString = ""
    foundUser.moments.each{
      presentationString += "$foundUser.name Posted on $it.timestamp | $it.body\n"
    }
    presentationString
  }

  private def addToFwiends(name) {
    currentUser.addToFwiends(findUser(name))
  }

  private def formatErrorString(name){
    return "Can't find $name Please enter valid user"
  }

  private def assignToCurrentUser(name){
    this.currentUser = findUser(name)
  }

  private def findUser(name){
    this.users.find {it.name == name}
  }

  private def createNewUser(name){
    this.currentUser = fwiendKlass.newInstance(name)
    this.users << currentUser
  }
}
