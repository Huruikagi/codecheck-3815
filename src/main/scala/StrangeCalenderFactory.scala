
/**
  * 拡張カレンダーを生成するファクトリです。
  *
  * @param y 1年を構成する日数
  * @param m 1ヵ月を構成する日数
  * @param d 1週間を構成する日数
  */
class StrangeCalenderFactory(y: Int, m: Int, d: Int) {

  /**
    * 1年を構成する日数
    */
  val daysInYear: Int = y

  /**
    * 1週間を構成する日数
    */
  val daysInMonth: Int = m

  /**
    * 1週間を構成する日数
    */
  val daysInWeek: Int = d


  /**
    * 文字列からカレンダーを生成します。
    *
    * @param date yyyy-mm-dd形式の文字列
    * @return 作成されたカレンダーオブジェクト
    */
  def create(date: String): Option[StrangeCalender] = {

    try {
      // 日付文字列を分解する
      val year = date.substring(0, 4).toInt
      val month = date.substring(5, 7).toInt
      val day = date.substring(8, 10).toInt

      // 与えられた引数の内容が正しいかを検証
      require(isValidDate(year, month, day))

      // 大丈夫なときはカレンダーを生成して返却する
      Some(new StrangeCalender(this, year, month, day))

    } catch {
      // エラー捕捉時はNoneで返却
      case _: NumberFormatException => None
      case _: IllegalArgumentException => None
    }

  }


  private def isValidDate(year: Int, month: Int, day: Int): Boolean = {
    year > 0 &&
    month > 0 &&
    day > 0 &&
    day <= daysInMonth
  }

}
