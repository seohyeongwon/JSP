package org.comstudy.myweb.shop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.comstudy.myweb.controller.Controller;

public class ShopController implements Controller {
   // 상품 목록
   static private List<Product> productList = new ArrayList<Product>();
   static {
      productList.add(new Product(1, "냉장고", 400, 0));
      productList.add(new Product(2, "세탁기", 200, 0));
      productList.add(new Product(3, "에어컨", 200, 0));
      productList.add(new Product(4, "선풍기", 7, 0));
      productList.add(new Product(5, "노트북", 300, 0));
      productList.add(new Product(6, "컴퓨터", 250, 0));
      productList.add(new Product(7, "테레비", 300, 0));
      productList.add(new Product(8, "인덕션", 200, 0));
      productList.add(new Product(9, "마우스", 5, 0));
      productList.add(new Product(10, "건조기", 100, 0));
      productList.add(new Product(11, "청소기", 120, 0));
      productList.add(new Product(12, "핸드폰", 150, 0));
   }
   
   HttpSession session;

   @Override
   public String execute(HttpServletRequest req) {
      session = req.getSession();
      
      String filePath = (String)req.getAttribute("filePath");
      String viewName = "shop/product_list";
      if("/product_list.do".equals(filePath)) {
         // 상품 목록 request에 저장
         req.setAttribute("productList", productList);
         // 페이지 전환
         viewName = "shop/product_list";
      } else if("/product_detail.do".equals(filePath)) {
         // 상품을 session의 cartList에 추가한다.
         int seq = Integer.parseInt(req.getParameter("seq"));
         Product product = null;
         for(int i=0; i<productList.size(); i++) {
            if(productList.get(i).getSeq() == seq) {
               product = productList.get(i);
               break;
            }
         }
         req.setAttribute("product", product);
         viewName = "shop/product_detail";
      } else if("/cart_list.do".equals(filePath)) {
         // 상품을 session의 cartList에 추가한다.
         List<Product> cartList = null;
         if(session.getAttribute("cartList") != null) {
            // session에 cartList가 있다면 cartList 참조
            cartList = (List<Product>)session.getAttribute("cartList");
         } else {
            // session에 없다면 새 리스트를 만들어서 session 저장.
            cartList = new ArrayList<Product>();
            session.setAttribute("cartList", cartList);
         }
         
         if(req.getParameter("seq")!=null && req.getParameter("ea")!=null) {
            int seq = Integer.parseInt(req.getParameter("seq"));
            int ea = Integer.parseInt(req.getParameter("ea"));
         
            Product product = null;
            for(int i=0; i<productList.size(); i++) {
               if(productList.get(i).getSeq() == seq) {
                  product = productList.get(i);
                  break;
               }
            }
            if(product != null) {
               int index = cartList.indexOf(new Product(seq));
               if(index != -1) {
                  Product curProduct = cartList.get(index);
                  curProduct.setEa(curProduct.getEa() + ea);
               } else {
                  String pName = product.getpName();
                  int price = product.getPrice();
                  Product newProduct = new Product(seq, pName, price, ea);
                  cartList.add(newProduct);
               }
            }
         } // end of if
         int totalPrice = 0;
         for(Product p : cartList) {
            int total = p.getPrice() * p.getEa();
            totalPrice += total;
         }
         
         req.setAttribute("cartList", cartList);
         req.setAttribute("totalPrice", totalPrice);
         viewName = "shop/cart_list";
      } else if("/cart_delete.do".equals(filePath)) {
         List<Product> cartList = null;
         if(session.getAttribute("cartList") != null) {
            // session에 cartList가 있다면 cartList 참조
            cartList = (List<Product>)session.getAttribute("cartList");
         } else {
            // session에 없다면 새 리스트를 만들어서 session 저장.
            cartList = new ArrayList<Product>();
            session.setAttribute("cartList", cartList);
         }
         // session에서 cartList를 가져와서 처리한다.
         int seq = Integer.parseInt(req.getParameter("seq"));
         int idx = cartList.indexOf(new Product(seq));
         if(idx != -1) {
            cartList.remove(idx);
         }
         viewName = "redirect:cart_list.do";
      }
      
      return viewName;
   }

}