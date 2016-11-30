/**
 * Amigos.js
 *
 * @description :: TODO: Tabla de amigos 
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {

  connection: 'PostgresqlServer',
    attributes: {
    id_u: {
      type: 'integer',
      required: true
    }
  }
};

