package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.request.creator.CommentCreatorRequest;
import com.ecommerce.model.response.list.ICommentList;

public interface CommentService {

	public List<ICommentList> getCommentByProduct(Long productId);

	public List<ICommentList> postComment(CommentCreatorRequest commentCreator);
}
