/**
 * Categorias_preferidas.js
 *
 * @description :: TODO: Tabla de union entre id de usuario y Categorias_preferidas (actualmente no en uso)
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {

connection: 'PostgresqlServer',
  attributes: {
    id_u: {
    type: 'integer',
    require:true
    }
  }
};

