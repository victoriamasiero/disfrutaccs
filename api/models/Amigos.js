/**
 * Amigos.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {

  connection: 'mysql',
    attributes: {
    id_amigo: {
    type: 'integer',
    unique: true,
    autoIncrement: true
    },
    id_u: {
      type: 'integer',
      required: true
    }
  }
};

