
     
            <div class="header">
                        
                    <div class='menu' id='menubar' onclick="openNav();"  >
                        <span  id='menu-symbol' class='symbol'><i class="fas fa-bars"></i></span><!--&#9776; -->
                        <span  id='menu-x' class='symbol-x'><i class="fas fa-times"></i></span>
                    </div>  
                    <div class='logo'>
                        <img src='<%=getServletContext().getContextPath() %>/images/logo.png' alt='Nome Negozio' title='Logo Nome Negozio'> 
                        <p></p> 
                    </div>
                    <div class='cerca'>
                     
                    </div>
                    <div class='accedi'  onclick="closeNav(),scrollToDiv('accedi'),scrollToDivForAll('accedi')">
                        <span><a >Accedi</a></span><!--&#128722;-->
                    </div>
                    
            </div>
     