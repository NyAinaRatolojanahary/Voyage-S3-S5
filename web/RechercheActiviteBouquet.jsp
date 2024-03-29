<%@page import="models.Bouquet"%>
<%@page import="java.util.ArrayList"%>

<%    
    Bouquet bq = new Bouquet();
    ArrayList<Bouquet> lsbq = bq.selectAll();
%>

<%
    Exception exp = (Exception)request.getAttribute("exception");
    String errMess = null;
    if(exp!= null){
        errMess = exp.getMessage();
    }
%>


<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
	<meta name="author" content="AdminKit">
	<meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">
	<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

	<title>Ajout</title>

	<link href="assets/css/app.css" rel="stylesheet">
        <link href="" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<nav id="sidebar" class="sidebar js-sidebar">
			<div class="sidebar-content js-simplebar">
				<a class="sidebar-brand" href="index.jsp">
          <span class="align-middle">Vakansy</span>
        </a>

				<ul class="sidebar-nav">
					<li class="sidebar-header">
						Pages
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="index.jsp">
              <i class="align-middle" data-feather="log-in"></i> <span class="align-middle">Dashboard</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-header">
						Activite
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="AjoutActivite.jsp">
              <i class="align-middle" data-feather="log-in"></i> <span class="align-middle">Ajout activite</span>
            </a>
					</li>
                                        
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="AjoutBillet.jsp">
              <i class="align-middle" data-feather="log-in"></i> <span class="align-middle">Ajout Billet Stock</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="ListeStockBilletActivite.jsp">
              <i class="align-middle" data-feather="log-in"></i> <span class="align-middle">Liste billet d'activite disponible en stock</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-header">
						Bouquet
					</li>
                                        
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./AjoutBouquet.jsp">
              <i class="align-middle" data-feather="user"></i> <span class="align-middle">Ajout bouquet</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-header">
						Localisation
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="TypeLocalisation.jsp">
              <i class="align-middle" data-feather="book"></i> <span class="align-middle">type localisation</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="Localisation.jsp">
              <i class="align-middle" data-feather="book"></i> <span class="align-middle">localisation</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-header">
						Activite Bouquet
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="./RechercheActiviteBouquet.jsp">
              <i class="align-middle" data-feather="search"></i> <span class="align-middle">Recherche Activite par Bouquet</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="ActiviteBouquet.jsp">
              <i class="align-middle" data-feather="user-plus"></i> <span class="align-middle">Ajout d'activite dans un bouquet</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-header">
						Voyage
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="./NouveauVoyage.jsp">
              <i class="align-middle" data-feather="book"></i> <span class="align-middle">Nouveau Voyage</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="./FiltreVoyageParPrix.jsp">
              <i class="align-middle" data-feather="search"></i> <span class="align-middle">Filtre voyage par Prix</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="./FiltreVoyageParBenefice.jsp">
              <i class="align-middle" data-feather="search"></i> <span class="align-middle">Filtre voyage par Benefice</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-header">
						Client
					</li>
                                        
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="AjoutClient.jsp">
              <i class="align-middle" data-feather="log-in"></i> <span class="align-middle">Ajout Client</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="AjoutVente.jsp">
              <i class="align-middle" data-feather="log-in"></i> <span class="align-middle">Effectuer une Vente de billet de voyage</span>
            </a>
					</li>
                                         
                                        <li class="sidebar-header">
						Employee
					</li>
                                        
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./AjoutEmployee.jsp">
              <i class="align-middle" data-feather="sliders"></i> <span class="align-middle">Ajout de nouveau Employee</span>
            </a>
					</li>
                                        
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./Affectation.jsp">
              <i class="align-middle" data-feather="sliders"></i> <span class="align-middle">Affectation d'employee</span>
            </a>
					</li>
                                        
					

					

					
                                        
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./ListePoste.jsp">
              <i class="align-middle" data-feather="sliders"></i> <span class="align-middle">Liste Employee</span>
            </a>
					</li>

                                        
                                        <li class="sidebar-header">
						Recherche
					</li>
                                        
                                        
                                        
                                        <li class="sidebar-item">
						<a class="sidebar-link" href="./RechercheVoyageParActivite.jsp">
              <i class="align-middle" data-feather="search"></i> <span class="align-middle">Recherche voyage par Activite</span>
            </a>
					</li>

				</ul>

				<div class="sidebar-cta">
					<div class="sidebar-cta-content">
						<strong class="d-inline-block mb-2">Upgrade to Pro</strong>
						<div class="mb-3 text-sm">
							Are you looking for more components? Check out our premium version.
						</div>
						<div class="d-grid">
							<a href="upgrade-to-pro.html" class="btn btn-primary">Upgrade to Pro</a>
						</div>
					</div>
				</div>
			</div>
		</nav>

		<div class="main">
			<nav class="navbar navbar-expand navbar-light navbar-bg">
				<a class="sidebar-toggle js-sidebar-toggle">
          <i class="hamburger align-self-center"></i>
        </a>

				<div class="navbar-collapse collapse">
					<ul class="navbar-nav navbar-align">
						<li class="nav-item dropdown">
							<a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown" data-bs-toggle="dropdown">
								<div class="position-relative">
									<i class="align-middle" data-feather="bell"></i>
									<span class="indicator">4</span>
								</div>
							</a>
							<div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="alertsDropdown">
								<div class="dropdown-menu-header">
									4 New Notifications
								</div>
								<div class="list-group">
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-danger" data-feather="alert-circle"></i>
											</div>
											<div class="col-10">
												<div class="text-dark">Update completed</div>
												<div class="text-muted small mt-1">Restart server 12 to complete the update.</div>
												<div class="text-muted small mt-1">30m ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-warning" data-feather="bell"></i>
											</div>
											<div class="col-10">
												<div class="text-dark">Lorem ipsum</div>
												<div class="text-muted small mt-1">Aliquam ex eros, imperdiet vulputate hendrerit et.</div>
												<div class="text-muted small mt-1">2h ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-primary" data-feather="home"></i>
											</div>
											<div class="col-10">
												<div class="text-dark">Login from 192.186.1.8</div>
												<div class="text-muted small mt-1">5h ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-success" data-feather="user-plus"></i>
											</div>
											<div class="col-10">
												<div class="text-dark">New connection</div>
												<div class="text-muted small mt-1">Christina accepted your request.</div>
												<div class="text-muted small mt-1">14h ago</div>
											</div>
										</div>
									</a>
								</div>
								<div class="dropdown-menu-footer">
									<a href="#" class="text-muted">Show all notifications</a>
								</div>
							</div>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-icon dropdown-toggle" href="#" id="messagesDropdown" data-bs-toggle="dropdown">
								<div class="position-relative">
									<i class="align-middle" data-feather="message-square"></i>
								</div>
							</a>
							<div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="messagesDropdown">
								<div class="dropdown-menu-header">
									<div class="position-relative">
										4 New Messages
									</div>
								</div>
								<div class="list-group">
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<img src="img/avatars/avatar-5.jpg" class="avatar img-fluid rounded-circle" alt="Vanessa Tucker">
											</div>
											<div class="col-10 ps-2">
												<div class="text-dark">Vanessa Tucker</div>
												<div class="text-muted small mt-1">Nam pretium turpis et arcu. Duis arcu tortor.</div>
												<div class="text-muted small mt-1">15m ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<img src="img/avatars/avatar-2.jpg" class="avatar img-fluid rounded-circle" alt="William Harris">
											</div>
											<div class="col-10 ps-2">
												<div class="text-dark">William Harris</div>
												<div class="text-muted small mt-1">Curabitur ligula sapien euismod vitae.</div>
												<div class="text-muted small mt-1">2h ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<img src="img/avatars/avatar-4.jpg" class="avatar img-fluid rounded-circle" alt="Christina Mason">
											</div>
											<div class="col-10 ps-2">
												<div class="text-dark">Christina Mason</div>
												<div class="text-muted small mt-1">Pellentesque auctor neque nec urna.</div>
												<div class="text-muted small mt-1">4h ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<img src="img/avatars/avatar-3.jpg" class="avatar img-fluid rounded-circle" alt="Sharon Lessman">
											</div>
											<div class="col-10 ps-2">
												<div class="text-dark">Sharon Lessman</div>
												<div class="text-muted small mt-1">Aenean tellus metus, bibendum sed, posuere ac, mattis non.</div>
												<div class="text-muted small mt-1">5h ago</div>
											</div>
										</div>
									</a>
								</div>
								<div class="dropdown-menu-footer">
									<a href="#" class="text-muted">Show all messages</a>
								</div>
							</div>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
                <i class="align-middle" data-feather="settings"></i>
              </a>

							<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
                <img src="img/avatars/avatar.jpg" class="avatar img-fluid rounded me-1" alt="Charles Hall" /> <span class="text-dark">Charles Hall</span>
              </a>
							<div class="dropdown-menu dropdown-menu-end">
								<a class="dropdown-item" href="pages-profile.html"><i class="align-middle me-1" data-feather="user"></i> Profile</a>
								<a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="pie-chart"></i> Analytics</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="index.jsp"><i class="align-middle me-1" data-feather="settings"></i> Settings & Privacy</a>
								<a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="help-circle"></i> Help Center</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">Log out</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>

			<main class="content">
				<div class="container-fluid p-0">

					<h1 class="h3 mb-3">Recherche Activite par bouquet</h1>

					<div class="row">
						<div class="col-12">
							<div class="card">
								
								<div class="card-body">
                                    <div class="card-body">
                                        <div class="m-sm-4">
                                            <form action="./ActiviteBouquetServlet" method="POST">
                                                <div class="mb-3">
                                                    <label class="form-label">Bouquet</label>

                                                    <select class="form-select mb-3" name="idBouquet">
                                                        <% for(int i=0; i<lsbq.size();i++){%>
                                                        <option value="<%out.print(lsbq.get(i).getIdBouquet());%>"><%out.print(lsbq.get(i).getNomBouquet());%></option>
                                                        <%}%>
                                                     </select>
                                                </div>
                                                
                                                <div class="text-center mt-3">
<!--                                                    <a href="index.jsp" class="btn btn-lg btn-primary">Sign up</a>-->
                                                     <button type="submit" class="btn btn-lg btn-primary">Valider</button> 
                                                </div>
                                            </form>
                                        </div>
                                    </div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</main>

			<footer class="footer">
				<div class="container-fluid">
					<div class="row text-muted">
						<div class="col-6 text-start">
							<p class="mb-0">
								<a class="text-muted" href="https://adminkit.io/" target="_blank"><strong>AdminKit</strong></a> &copy;
							</p>
						</div>
						<div class="col-6 text-end">
							<ul class="list-inline">
								<li class="list-inline-item">
									<a class="text-muted" href="https://adminkit.io/" target="_blank">Support</a>
								</li>
								<li class="list-inline-item">
									<a class="text-muted" href="https://adminkit.io/" target="_blank">Help Center</a>
								</li>
								<li class="list-inline-item">
									<a class="text-muted" href="https://adminkit.io/" target="_blank">Privacy</a>
								</li>
								<li class="list-inline-item">
									<a class="text-muted" href="https://adminkit.io/" target="_blank">Terms</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>

	<script src="assets/js/app.js"></script>

</body>

</html>