                var opened=0;
                var dimensioniFinestraBroswer=0;
                var dimensioniMenuBar=0;
                var percentualeMenu=0;
                
                function resize(){
                        dimensioniFinestraBroswer=window.innerWidth;
                        if(dimensioniFinestraBroswer>600)
                         {
                                opened=1;
                                percentualeMenu=20/100;
                                dimensioniMenuBar=(dimensioniFinestraBroswer*percentualeMenu);
                                document.body.style.marginLeft=(percentualeMenu*100)+"%";
                                document.body.style.width=""+100-percentualeMenu*100+"%";
                                document.getElementById("mySidenav").style.height = "100%";
                                document.getElementById("mySidenav").style.width = percentualeMenu*100+"%";       
                         }
                         else{
                                 closeNav();
                         }       
                }
                function openNav() {
                    dimensioniFinestraBroswer=window.innerWidth;
                    if(dimensioniFinestraBroswer<=600){
                        if(opened==0){
                                document.getElementById("menu-symbol").style.display="none";     
                                document.getElementById("menu-x").style.display="block"; 
                                document.getElementById("menubar").style.backgroundColor="white";
                                document.getElementById("menubar").style.borderBottom="1px solid white";  
                                document.body.style.overflow = "hidden";        
                                opened=1;
                                if(dimensioniFinestraBroswer<400){       
                                        percentualeMenu=100/100;
                                        dimensioniMenuBar=(dimensioniFinestraBroswer*percentualeMenu);
                                }
                                else if(dimensioniFinestraBroswer<=600){
                                        percentualeMenu=100/100;
                                        dimensioniMenuBar=(dimensioniFinestraBroswer*percentualeMenu);
                                }
                                document.getElementById("mySidenav").style.height =100+"%";  
                                //document.getElementById("mySidenav").style.paddingTop="30px";  



                        }
                        else{
                                closeNav();
                        }
                    }
                    
                }
                
                function closeNav() {
                        dimensioniFinestraBroswer=window.innerWidth;
                        if(dimensioniFinestraBroswer<=600){
                                document.getElementById("menu-x").style.display="none";      
                                document.getElementById("menu-symbol").style.display="block";
                                document.getElementById("menubar").style.backgroundColor="white";
                                document.getElementById("menubar").style.color="#141414";   
                                document.getElementById("menubar").style.borderBottom="0px";
                                document.body.style.overflowY = "auto";
                                opened=0;
                                document.body.style.margin="0 auto";
                                document.body.style.width="100%";
                                
                                document.getElementById("mySidenav").style.paddingTop="0px";  
                                document.getElementById("mySidenav").style.width = "100%";  
                                document.getElementById("mySidenav").style.height = "0";

                        }
                        
                }