package dvd.service;

import dvd.mvc.model.DvdDTO;
import dvd.repository.DvdRepository;

public class DvdService {
	private static DvdService instance = new DvdService();

	public static DvdService getInstance() {
		return instance;
	}

	//------------------------------------------

	private DvdRepository dvdRepository = new DvdRepository();

	/**
	 * dvd 조회
	 * @param dvdId
	 * @return
	 */
	public DvdDTO getDvdDetail(String dvdId) {
		return dvdRepository.findById(dvdId);
	}

}
