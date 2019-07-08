package examples.aaronhoskins.com.mvpexample.model.datasource.local.database;

import java.util.Locale;

public class TvDatabaseContract {
    public static final String DATABASE_NAME = "tvshow_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_TVSHOW = "table_tv_show";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESC = "description";
    public static final String COLUMN_RATING = "rating";
    public static final String COLUMN_SEASON = "season";

    //Create Table Query
    public static final String CREATE_TABLE_QUERY =
            String.format(Locale.US,
                    "CREATE TABLE %s (%s TEXT PRIMARY_KEY, %s TEXT, %s NUMBER, %s TEXT)",
                    TABLE_TVSHOW, COLUMN_TITLE, COLUMN_DESC, COLUMN_SEASON, COLUMN_RATING);

    //Selection Queries
    private static final String BASE_SELECT_QUERY = "SELECT * FROM %s";
    public static final String SELECT_ALL_SHOWS_QUERY =
            String.format(Locale.US, BASE_SELECT_QUERY, TABLE_TVSHOW);
    public static final String SELECT_BY_TITLE_QUERY = String.format(Locale.US,
            "%s WHERE %s = ", BASE_SELECT_QUERY, COLUMN_TITLE);
    public static String getSelectByTitleQuery(final String title) {
        return String.format(Locale.US, "%s \'%s\'", SELECT_BY_TITLE_QUERY, title);
    }

}
