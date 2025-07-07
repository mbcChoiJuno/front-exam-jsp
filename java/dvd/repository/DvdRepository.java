package dvd.repository;

import java.util.ArrayList;

import dvd.mvc.model.DvdDAO;
import dvd.mvc.model.DvdDTO;

public class DvdRepository implements IRepository <DvdDTO, String> {

	private DvdDAO dvdDao = new DvdDAO();

	@Override
	public void post(DvdDTO dto) {
		dvdDao.insert(dto);
	}

	@Override
	public DvdDTO findById(String id) {
		return dvdDao.findById(id);
	}

	@Override
	public ArrayList<DvdDTO> findAll() {
		return dvdDao.findAll();
	}

	@Override
	public void update(String id, DvdDTO dto) {
		dvdDao.update(id, dto);
	}

	@Override
	public void delete(String id) {
		dvdDao.delete(id);
	}

}
