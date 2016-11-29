
object Main {

  /**
    * 実行用関数
    *
    * @param args daysInYear, daysInMonth, daysInWeek, date
    */
  def main(args: Array[String]): Unit = {

    // コマンドライン引数で渡された情報を整理
    // 日付の形式が不正ではない前提なのでそこはノーチェック
    val daysInYear: Int = args(0).toInt
    val daysInMonth: Int = args(1).toInt
    val daysInWeek: Int = args(2).toInt
    val date: String = args(3)

    // ファクトリの生成
    val factory = new StrangeCalenderFactory(daysInYear, daysInMonth, daysInWeek)

    // ファクトリをもとにカレンダーの実態を生成
    val calender = factory.create(date)

    // ちゃんと生成できたかどうかに応じて出力内容を変更
    calender match {
      case Some(c) => println(c.dayOfWeek)
      case None => println(-1)
    }

  }
}
