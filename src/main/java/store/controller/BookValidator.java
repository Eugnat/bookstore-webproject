package store.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class BookValidator {
	
	public boolean validate(HttpServletRequest request, String isbn, String category, String imageUrl, int issueYear)
	{
		String msg = "";
		
		List<String> list = new ArrayList<>();
		list.add("fiction");
		list.add("art work");
		list.add("children");
		list.add("history");
		list.add("poetry");
		
		boolean result = true;
		
		if (isbn.length() != 13)
			{
				result = false;
				msg += "Incorrect ISBN format, 13 digits are required. ";
			}
		
		if (!imageUrl.endsWith("jpg"))
		{
			result = false;
			msg += "Incorrect image URL format, please check again. ";
		}
		
		if (issueYear < 1950)
		{
			result = false;
			msg += "Too old for a book in our store. ";
		}
		
		if (issueYear > 2016)
		{
			result = false;
			msg += "Incorrect year, please check. ";
		}
		
		for (String value : list)
		{
			result = false;
			if (value.equalsIgnoreCase(category))
				{
					result = true;
					break;
				}
		}
		
		if (!result)
			msg += "Proposed category is not selected. ";
		
		request.setAttribute("message", msg);
		
		return result;
	}

}
