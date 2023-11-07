package jz.cbq.android.complex_template.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import jz.cbq.android.complex_template.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDbHelper
 *
 * @author Cola777jz
 * @date 2023/11/7 13:53
 * @since 1.0.0
 */
public class UserDbHelper extends SQLiteOpenHelper {
    private static UserDbHelper sHelper;
    private static final String DB_NAME = "user.db";   //数据库名
    private static final int VERSION = 1;    //版本号

    //必须实现其中一个构方法
    public UserDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 创建单例，供使用调用该类里面的的增删改查的方法
     *
     * @param context context
     * @return UserDbHelper
     */
    public synchronized static UserDbHelper getInstance(Context context) {
        if (null == sHelper) {
            sHelper = new UserDbHelper(context, DB_NAME, null, VERSION);
        }
        return sHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建 user_table 表
        db.execSQL("create table user_table(user_id integer primary key autoincrement, " +
                "username text," +
                "password text," +
                "nickname text" +
                ")");
        db.execSQL("insert into user_table values(null,'cbq','cb','TODO')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    /**
     * 注册
     *
     * @param username username
     * @param password password
     * @return count
     */
    public int register(String username, String password, String nickname) {
        //获取 SQLiteDatabase 实例
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //填充占位符
        values.put("username", username);
        values.put("password", password);
        values.put("nickname", nickname);
        String nullColumnHack = "values(null,?,?,?)";
        //执行
        int insert = (int) db.insert("user_table", nullColumnHack, values);
        db.close();
        return insert;
    }

    /**
     * 登录  根据用户名查找用户
     */
    @SuppressLint("Range")
    public UserInfo login(String username) {
        //获取 SQLiteDatabase 实例
        SQLiteDatabase db = getReadableDatabase();
        UserInfo userInfo = null;
        String sql = "select user_id,username,password,nickname  from user_table where username=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {
            int user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            userInfo = new UserInfo(user_id, name, password, nickname);
        }
        cursor.close();
        db.close();
        return userInfo;
    }

    /**
     * 获取所有注册用户
     */
    @SuppressLint("Range")
    public List<UserInfo> queryRegisterListData() {
        //获取 SQLiteDatabase 实例
        SQLiteDatabase db = getReadableDatabase();
        List<UserInfo> list = new ArrayList<>();
        String sql = "select _id,username,password,register_type  from user_table";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int user_id = cursor.getInt(cursor.getColumnIndex("user_id"));
            String name = cursor.getString(cursor.getColumnIndex("username"));
            String password = cursor.getString(cursor.getColumnIndex("password"));
            String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            list.add(new UserInfo(user_id, name, password, nickname));
        }
        cursor.close();
        db.close();
        return list;
    }

    /**
     * 根据用户唯一 user_id 来修改密码
     */
    public int updatePwd(int user_id, String password) {
        SQLiteDatabase db = getWritableDatabase();
        // 填充占位符
        ContentValues values = new ContentValues();
        values.put("password", password);
        // 执行SQL
        int update = db.update("user_table", values, " user_id=?", new String[]{user_id + ""});
        // 关闭数据库连接
        db.close();
        return update;

    }

    /**
     * 根据用户 唯一 user_id 删除用户
     */
    public int delete(String user_id) {
        //获取 SQLiteDatabase 实例
        SQLiteDatabase db = getWritableDatabase();
        // 执行 SQL
        int delete = db.delete("user_table", " user_id=?", new String[]{user_id});
        // 关闭数据库连接
        db.close();
        return delete;
    }

}
