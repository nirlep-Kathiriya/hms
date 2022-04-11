package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.FeedbackDAO;
import com.hms.model.FeedbackVO;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService{
   @Autowired
   private FeedbackDAO feedbackDAO;

	@Override
	public void insertFeedback(FeedbackVO feedbackVO) {
		// TODO Auto-generated method stub
	  this.feedbackDAO.insertFeedback(feedbackVO);	
	}

	@Override
	public List<FeedbackVO> viewFeedback() {
		return this.feedbackDAO.viewFeedback();
	}

	
}
