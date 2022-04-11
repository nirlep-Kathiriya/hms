package com.hms.dao;

import java.util.List;

import com.hms.model.FeedbackVO;

public interface FeedbackDAO {


	void insertFeedback(FeedbackVO feedbackVO);

	List<FeedbackVO> viewFeedback();

}
