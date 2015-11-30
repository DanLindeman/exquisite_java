public class CthuluBattleModel
{
    private int cthulu_health, player_health;

    public CthuluBattleModel()
    {

    }

    public void start(int good_big, int bad_big)
    {
        cthulu_health = bad_big;
        player_health = good_big;
    }

}