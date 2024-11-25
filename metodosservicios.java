public void eliminarServicios(SelectedItem item){
    //Eliminar el item de la base de datos
    bd.execute("DELETE FROM servicios WHERE servicios.nombre = "+item+"");
}
public void actualizarTabla(){
    vs.getList().Remove();
    vs.getList().setEmpty();
    ResultSet rs = bd.query("SELECT * FROM servicios");
    while(rs.next()){
        vs.getList().add(rs.getInt(1));
        vs.getList().add(rs.getString(2));
        vs.getList().add(rs.getString(3));
        vs.getList().add(rs.getString(4));
        vs.getList().add(rs.getDouble(5));
        vs.getList().add(rs.getDate(6));
    }
    vs.getContentPane().add(PanelList());
}
public void añadirServicios(){
    //Coger Datos con id+1
    bd.execute("INSER INTO servicios WHERE ()")
}