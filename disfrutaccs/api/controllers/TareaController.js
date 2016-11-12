/**
 * TareaController
 *
 * @description :: Server-side logic for managing tareas
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {

	busqueda: function(req,res,next){
		
		if( req.param('pregunta')=== '1'){
		res.redirect('/tarea/p'+req.param('pregunta'));

		}
		
		if(req.param('pregunta')==='2'){

		res.redirect('/tarea/p'+req.param('pregunta'));


			
		}

		if(req.param('pregunta')==='3'){



		res.redirect('/tarea/p'+req.param('pregunta'));
			
		}

		if(req.param('pregunta')==='4'){


		res.redirect('/tarea/p'+req.param('pregunta'));

			
		}

		if(req.param('pregunta')==='5'){


			res.redirect('/tarea/p'+req.param('pregunta'));	
			}

		},



		p1 : function(req, res, next){

			 Tarea.query(
			 'select b.first_name, PelisRentadas from (select s.first_name, count(r.staff_id) as PelisRentadas, sum(p.amount) as GananciaTotal from staff s inner join payment p  on s.staff_id = p.staff_id inner join rental r on r.staff_id = p.staff_id group by s.staff_id order by PelisRentadas desc limit 1) b;'
			 ,function(err, resultado) {
 			 if (err) return res.serverError(err);	
 				 var aux = JSON.stringify(resultado[0]);
        		 resultado = JSON.parse(aux);

				 res.view({respuesta:resultado});



			});


		},

		p2: function(req, res, next) {
			
		}






	}









