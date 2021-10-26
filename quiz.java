try {
            Connection con;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root","");
            String str="select * from admin_info where user=? and pass=?";
            PreparedStatement pstmt = con.prepareStatement(str);
            String user=usernamet.getText();
            String pass=passt.getText();
            pstmt.setObject(1,user);
            pstmt.setObject(2,pass);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
              
                JOptionPane.showMessageDialog(null,"Login Successfull");
                this.dispose();
                new Admin_home().setVisible(true);
              
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Login Unsuccessfull");
                usernamet.setText("");
                passt.setText("");
            }
            con.close();
        } catch (SQLException ex){}