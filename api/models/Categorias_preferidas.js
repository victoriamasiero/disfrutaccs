/**
 * Categorias_preferidas.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {

connection: 'PostgresqlServer',
  attributes: {
    id_c: {
    type: 'integer',
    require:true
    },
    id_u: {
    type: 'integer',
    require:true
    }
  }
};

