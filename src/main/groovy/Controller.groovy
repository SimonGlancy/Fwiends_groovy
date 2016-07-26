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

  def assignToCurrentUser(name){
    this.currentUser = findUser(name)
  }

  def findUser(name){
    this.users.find {it.name == name}
  }

  def createNewUser(name){
    this.currentUser = fwiendKlass.newInstance(name)
    this.users << currentUser
  }
}
