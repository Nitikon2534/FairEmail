package eu.faircode.email;

/*
    This file is part of FairEmail.

    FairEmail is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FairEmail is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with FairEmail.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2018-2023 by Marcel Bokhorst (M66B)
*/

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoSync {
    @Query("SELECT * FROM sync" +
            " WHERE (:entity IS NULL OR entity = :entity)" +
            " AND (:reference IS NULL OR reference = :reference)" +
            " AND time <= :time" +
            " ORDER BY time")
    List<EntitySync> getSync(String entity, String reference, long time);

    @Query("DELETE FROM sync WHERE id= :id")
    int deleteSync(long id);

    @Query("DELETE FROM sync WHERE time <= :time")
    int deleteSyncByTime(long time);
}
