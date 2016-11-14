

module.exports = {

    buscarusuario: function(req,res,next){

        
        Usuario.findOne({Alias:req.param('Nombre')}).exec(function(err, resultado){

            if(resultado === undefined){
                res.notFound('Usuario no encontrado');
            }
             else{

                    if(req.param('Clave')!== resultado.Clave){
                        res.notFound('clave incorrecta');
                    }
                    else{
                            resultado.idactividad = req.param('idactividad');
                            resultado.Comentario = req.param('Comentario');
                            console.log(resultado);

                           res.view({Resena:resultado});
                    }
                }
        });

    },
 	
    nueva: function(req,res,next){

             Resena.create(req.params.all(), function Resenacreada (err, resena) {
                            
                             if(err) {return next(err);}
                              console.log(resena);
                             res.redirect ('/actividad/mostrar/'+resena.idactividad);
                         });

             
            /*Usuario_natural.findOne({Alias:req.param('Nombre')}).exec(function(err, resultado){
                

            if(resultado === undefined){
                res.notFound('Usuario no encontrado');
            }
            else{

                    if(req.param('Clave')!== resultado.clave){
                        res.notFound('clave incorrecta');
                    }
                    else{
                            console.log(req.idusuario);
                            req.idusuario = resultado.id;
                            console.log(req.idusuario);


                            Resenas.create(req.params.all(), function Resenacreada (err, resena) {
                                console.log(resena);

                             if(err) {return next(err);}

                             res.redirect ('/Local/mostrar/'+resena.owner);
        

                              });
                    }
                    


            }
            


        });*/
    
    }

	
};