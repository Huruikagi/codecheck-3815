
/**
  * 日付を保持する
  *
  * @param f このカレンダーを作成したファクトリオブジェクト
  * @param y 年
  * @param m 月
  * @param d 日
  */
class StrangeCalender(f: StrangeCalenderFactory, y: Int, m: Int, d: Int) {

  /**
    * 年
    */
  val year: Int = y

  /**
    * 月
    */
  val month: Int = m

  /**
    * 月の何日か
    */
  val dayOfMonth: Int = d

  /**
    * 曜日を表す文字
    */
  val dayOfWeek: Char = calcDayOfWeek()


  private def calcDayOfWeek(): Char = {

    // 1年あたりの「あまり日」
    val diffDayPerYear: Int = f.daysInYear % f.daysInMonth

    // うるう年が無い場合の、この年開始時までの「あまり日」の累積値
    val totalDiffDay: Int = diffDayPerYear * (y - 1)

    // この年までに閏月が何回あったか
    val leapMonthCount: Int = totalDiffDay / f.daysInMonth

    // この年が閏年であるか
    val isLeapYear: Boolean =
      y != 1 &&
      (totalDiffDay % f.daysInMonth) < diffDayPerYear
    // 閏年じゃなかった場合は月の制限がやや厳しいのでチェック
    if (!isLeapYear) require(m <= (f.daysInYear / f.daysInMonth))

    // 1年1月1日を0日目として、何日目か
    val totalDay: Int =
      ((f.daysInYear - diffDayPerYear) * (y - 1)) +
        (f.daysInMonth * (m - 1)) +
        (d - 1) +
        (f.daysInMonth * leapMonthCount)

    // 数値で表した曜日
    val dow: Int = totalDay % f.daysInWeek

    // 文字型に変換して返却する
    ('A'.toInt + dow).toChar

  }

}
