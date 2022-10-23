package ua.lviv.lgs12;

public enum Month {

    
    JANUARY(31, Season.WINTER),
    FEBRUARY(28, Season.WINTER),
    MARCH(31, Season.SPRING),
    APRIL(30, Season.SPRING),
    MAY(31, Season.SPRING),
    JUNE(30, Season.SUMMER),
    JULY(31, Season.SUMMER),
    AUGUST(31, Season.SUMMER),
    SEPTEMBER(30, Season.AUTUMN),
    OCTOBER(31, Season.AUTUMN),
    NOVEMBER(30, Season.AUTUMN),
    DECEMBER(31, Season.WINTER);
    
    private int days;
    private Season season;
 
    Month(int days, Season season) {
        this.days = days;
        this.season = season;
    }
 
    public int getDays() {
        return days;
    }
 
    public void setDays(int days) {
        this.days = days;
    }
 
    public Season getSeason() {
        return season;
    }
 
   public void setSeason(Season season) {
        this.season = season;
    }
    
}
