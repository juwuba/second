package com.yc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.TagBiz;
import com.yc.bizimple.FavoriteBizImple;
import com.yc.bizimple.TagBizImple;
import com.yc.web.serializable.JsonModel;

@WebServlet("/fav.do")
public class CloudServlet extends BasicServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(op.equals("findTags")){
			findTagsOP(request,response);
		}else if(op.equals("clickTags")){
			clickTagsOP(request,response);
		}else if(op.equals("insertFavorte")){
			insertFavorteOP(request,response);
		}else if(op.equals("clickTags1")){
			clickTags1OP(request,response);
		}
	}
	//云图
	private void clickTags1OP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FavoriteBiz fb=new FavoriteBizImple();
		List<Tag> list=fb.cloud();
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		jm.setObj(list);
		super.outJson(jm, response);



	}
	//插入标签
	private void insertFavorteOP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonModel jm=new JsonModel();
		FavoriteBiz fb=new FavoriteBizImple();
		try{
			Favorite fovorite=(Favorite) super.parseRequest(request, Favorite.class);
			Integer num=fb.insertInfo(fovorite);
			jm.setCode(1);
		}catch (Exception ex){
			ex.printStackTrace();
			jm.setCode(0);
			jm.setErrorMsg(ex.getMessage());
		}
		super.outJson(jm, response);
	}
	//点击标签
	private void clickTagsOP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		FavoriteBiz fb=new FavoriteBizImple();
		String id=request.getParameter("id");
		List<Favorite> favorite=fb.findFavorite(id);
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		jm.setObj(favorite);
		super.outJson(jm, response);
	}
	//给出所有标签
	private void findTagsOP(HttpServletRequest request, HttpServletResponse response) throws IOException {
		TagBiz tb=new TagBizImple();
		List<Tag> list=tb.findAllTags();
		JsonModel jm=new JsonModel();
		jm.setCode(1);
		jm.setObj(list);
		super.outJson(jm, response);

	}

}
