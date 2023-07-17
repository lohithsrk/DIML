package com.diml.room;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.diml.dataClass.LogEntity;
import com.diml.utils.Converter;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LogDAO_Impl implements LogDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LogEntity> __insertionAdapterOfLogEntity;

  private final Converter __converter = new Converter();

  private final EntityDeletionOrUpdateAdapter<LogEntity> __updateAdapterOfLogEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteLog;

  public LogDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLogEntity = new EntityInsertionAdapter<LogEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Log` (`id`,`title`,`description`,`date`,`liked`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LogEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final String _tmp = __converter.dateToTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        final int _tmp_1 = value.getLiked() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
      }
    };
    this.__updateAdapterOfLogEntity = new EntityDeletionOrUpdateAdapter<LogEntity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Log` SET `id` = ?,`title` = ?,`description` = ?,`date` = ?,`liked` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LogEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        final String _tmp = __converter.dateToTimestamp(value.getDate());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        final int _tmp_1 = value.getLiked() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteLog = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Log WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object addLog(final LogEntity log, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLogEntity.insert(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateLog(final LogEntity log, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfLogEntity.handle(log);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteLog(final int id, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteLog.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteLog.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<LogEntity>> getLikedLogs() {
    final String _sql = "SELECT * FROM Log WHERE liked = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Log"}, new Callable<List<LogEntity>>() {
      @Override
      public List<LogEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "liked");
          final List<LogEntity> _result = new ArrayList<LogEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LogEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final LocalDateTime _tmpDate;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfDate);
            }
            _tmpDate = __converter.fromTimestamp(_tmp);
            final boolean _tmpLiked;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfLiked);
            _tmpLiked = _tmp_1 != 0;
            _item = new LogEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpDate,_tmpLiked);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<LogEntity>> getLogsPerDate(final LocalDateTime currentDateTimeStart,
      final LocalDateTime currentDateTimeEnd) {
    final String _sql = "SELECT * FROM Log WHERE date >= ? AND date <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final String _tmp = __converter.dateToTimestamp(currentDateTimeStart);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    _argIndex = 2;
    final String _tmp_1 = __converter.dateToTimestamp(currentDateTimeEnd);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp_1);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"Log"}, new Callable<List<LogEntity>>() {
      @Override
      public List<LogEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfLiked = CursorUtil.getColumnIndexOrThrow(_cursor, "liked");
          final List<LogEntity> _result = new ArrayList<LogEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final LogEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final LocalDateTime _tmpDate;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfDate);
            }
            _tmpDate = __converter.fromTimestamp(_tmp_2);
            final boolean _tmpLiked;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfLiked);
            _tmpLiked = _tmp_3 != 0;
            _item = new LogEntity(_tmpId,_tmpTitle,_tmpDescription,_tmpDate,_tmpLiked);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
