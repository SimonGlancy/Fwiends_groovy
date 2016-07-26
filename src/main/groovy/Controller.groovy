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
    this.currentUser = fwiendKlass.newInstance(name)
  }

  def logOut() {
    this.currentUser = null
  }
}
