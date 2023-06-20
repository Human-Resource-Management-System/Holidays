package DAO;

import java.util.List;

import models.Holiday;

public interface HolidayDAO {
	List<Holiday> findAllHolidays();

	List<Holiday> findAlloptedHolidays();

	int countMandHolidays();

	Holiday findHolidayById(int id);

	void saveHoliday(Holiday holiday);

	void updateHoliday(Holiday holiday);

	void deleteHoliday(Holiday holiday);
}
