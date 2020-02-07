package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hyun Ji Lee (810783)
 */
public class ShoppingListServlet extends HttpServlet
{
    private HttpSession session = null;
    private ArrayList<String> itemList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("<<ShoppingListServlet / In doGet method>>");
        
        session = request.getSession();

        String parameterValue = request.getParameter("action");
        
        if(parameterValue != null && parameterValue.equals("logout"))
        {
            session.removeAttribute("username");
            session.removeAttribute("itemList");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("<<ShoppingListServlet / In doPost method>>");
        
        String parameterValue = request.getParameter("action");
        session = request.getSession();
        
        if(parameterValue.equals("register"))
        {
            String userName = request.getParameter("username");

            session.setAttribute("username", userName);
            session.removeAttribute("itemList");
            itemList = new ArrayList<>();
                
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }
        else if(parameterValue.equals("add"))
        {
            String inputItem = request.getParameter("inputItem");
            
            if(inputItem == null || inputItem.equals(""))
            {
                request.setAttribute("errorMessage", "Please fill in the input field!");
            }
            else
            {
                itemList.add(inputItem);
                session.setAttribute("itemList", itemList);
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }
        else if(parameterValue.equals("delete"))
        {
            String clickedRadioButton = request.getParameter("radioButton");
            
            if(clickedRadioButton == null)
            {
                request.setAttribute("errorMessage", "Please click one of the items to delete.");
            }
            else
            {
                for(int i = 0;  i < itemList.size(); i++)
                {
                    String oneItem = itemList.get(i);

                    if(clickedRadioButton.equals(oneItem))
                    {
                        itemList.remove(i);
                    }
                }
            }
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
