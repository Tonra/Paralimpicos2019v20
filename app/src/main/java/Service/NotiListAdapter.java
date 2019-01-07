package Service;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.diego.paralimpicos2019v20.R;

import java.util.List;

public class NotiListAdapter extends BaseAdapter {

    private Context context;
    private List<Notification> listaNotificacion;

    public NotiListAdapter(Context context, List<Notification> listaNotificacion) {
        this.context = context;
        this.listaNotificacion = listaNotificacion;
    }

    @Override
    public int getCount() {
        return listaNotificacion.size();
    }

    @Override
    public Object getItem(int position) {
        return listaNotificacion.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= View.inflate(context,R.layout.contenido_list_notificacion,null);
        TextView titulo=(TextView)v.findViewById(R.id.titulo);
        TextView texto=(TextView)v.findViewById(R.id.textobody);
        TextView hora=(TextView)v.findViewById(R.id.hora);
        //set
        titulo.setText(listaNotificacion.get(position).getTitulo());
        texto.setText(listaNotificacion.get(position).getTexto());
        hora.setText(listaNotificacion.get(position).getHora());

        v.setTag(listaNotificacion.get(position).getId());
        return v;
    }
}
