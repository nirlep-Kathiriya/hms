package com.hms.service;

import java.util.List;

import com.hms.model.FeedbackVO;

public interface FeedbackService {


	void insertFeedback(FeedbackVO feedbackVO);

	List<FeedbackVO> viewFeedback();

}
